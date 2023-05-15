/**
 * This class gets the data from the database contains basic CRUD methods that can be used(generally by any class
 * that extends this class) to create, read/find, update and delete the data in the database.
 */
package DataAccess;

import Connection.ConnectionFactory;
import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AbstractDAO <T> {

    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    public Class<T> getType() {
        return type;
    }

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * createSelectAllQuery() method creates a general query string for selecting all the fields from a certain table.
     * @return
     */
    public String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * The findAll() method gets a connection with the database, gets the data and return the obtained data as a List of
     * objects. List<T> means that the type will be defined in the runtime.
     * @return
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = createSelectAllQuery();

        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();

            return createObjects(rs);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAOfindAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(stmt);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     *
     * @param resultSet
     * createObjects() method receives a ResultSet as a parameter and gets the fields from using reflection techniques.
     * First the fieldNames then the values of that fields are obtained. The values are put in a List and returned.
     * @return
     */
    public List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = this.getType().getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : this.getType().getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, this.getType());
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param list
     * getTable() method gets as a parameter List of objects constructs the table header using the fields of the first
     * element and populates the table with the data in the List. All is done with the hepl of reflection techniques.
     * The table is returned as DefaultTableModel type.
     * @return
     */
    public DefaultTableModel getTable(List<T> list) {
        Vector<String> columnNames = new Vector<String>(); // TableHeader
        Vector<Vector<Object>> data = new Vector<Vector<Object>>(); // TableData
        Object object = list.get(0);
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                columnNames.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        ListIterator<T> iter = list.listIterator();
        while (iter.hasNext()) {
            Vector<Object> vector = new Vector<Object>();
            Object object1 = iter.next();
            for (Field field1 : object1.getClass().getDeclaredFields()) {
                field1.setAccessible(true);
                Object value;
                try {
                    value = field1.get(object1);
                    vector.add(value);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

    /**
     *
     * @param productName
     * checkProductQuantity() method gets the products name and checks the product quantity in the database and returns
     * the quantity of the product.
     * @return
     */
    public int checkProductQuantity(String productName) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = "SELECT quantityInStock from Product where productName = ?";

        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(query);
            stmt.setString(1, productName);
            rs = stmt.executeQuery();
            rs.next();

            int quantity = rs.getInt("quantityInStock");
            return quantity;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return 0;
    }

    /**
     *
     * @param clientName
     * @param productName
     * @param quantity
     * makeOrder() method gets a connection with the database and executes a procedure in the database. The procedure
     * updates the Orders and OrderedProduct tables in the database and decrements the quantity of the product.
     * @return
     */
    public boolean makeOrder(String clientName, String productName, int quantity) {
        Connection connection = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        String query = "{CALL makeOrder(?, ?, ?) }";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareCall(query);
            stmt.setString(1, clientName);
            stmt.setString(2, productName);
            stmt.setInt(3, quantity);

            if (checkProductQuantity(productName)-quantity>=0) {
                rs = stmt.executeQuery();
                return true;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(stmt);
            ConnectionFactory.close(connection);
        }
        return false;
    }

    /**
     *
     * @param field1
     * @param field2
     * @param field3
     * createInsertQuery() method generates a general SQL query for insertion in the database.
     * @return
     */
    public String createInsertQuery(String field1, String field2, String field3) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append("( " + field1 + ", " + field2 + ", " + field3 + " )");
        sb.append(" VALUES (?, ?, ?)");
        return sb.toString();
    }

    /**
     *
     * @param t
     * inset() method gets the connection with the database and executes the insertion in the database
     * @return
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> fieldNames = new ArrayList<>();
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                fieldNames.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        System.out.println(fieldNames);
        String query = createInsertQuery(fieldNames.get(1), fieldNames.get(2), fieldNames.get(3));
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int i = 1;
            int ver = 0;
            for (String fieldName : fieldNames) {
                Field field = t.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(t);
                if (ver != 0) {
                    stmt.setObject(i++, value);
                }
                ver++;
            }
            int rowsAffected = stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int insertedId = rs.getInt(1);
                System.out.println(insertedId);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(stmt);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    /**
     *
     * @param field1
     * @param entityId
     * @param field2
     * @param field3
     * @param field4
     * createUpdateQuery() method generates a general SQL update query.
     * @return
     */

    public String createUpdateQuery(String field1, int entityId, String field2, String field3, String field4) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET " + field2 + " = ?, ");
        sb.append(" " + field3 + " = ?, ");
        sb.append(" " + field4 + " = ? ");
        sb.append(" WHERE " + field1 + " = " + entityId);
        return sb.toString();

    }

    /**
     *
     * @param t
     * @param idValue
     * update() method gets the connection with the database and executes an update in the database.
     * @return
     */

    public T update(T t, int idValue) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> fieldNames = new ArrayList<>();
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                fieldNames.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
            String query = createUpdateQuery(fieldNames.get(0), idValue, fieldNames.get(1), fieldNames.get(2), fieldNames.get(3));

            try {
                connection = ConnectionFactory.getConnection();
                stmt = connection.prepareStatement(query);
                int i = 1;
                int ver = 0;
                for (String fieldName : fieldNames) {
                    Field field1 = t.getClass().getDeclaredField(fieldName);
                    field1.setAccessible(true);
                    Object value = field1.get(t);
                    if (ver != 0) {
                        stmt.setObject(i++, value);
                    }
                    ver++;
                }
                int rowsAffected = stmt.executeUpdate();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            } catch (NoSuchFieldException e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            } catch (IllegalAccessException e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            } finally {
                ConnectionFactory.close(rs);
                ConnectionFactory.close(stmt);
                ConnectionFactory.close(connection);
            }
            return t;
    }

    /**
     *
     * @param field
     * createDelete() method creates a general SQL delete query.
     * @return
     */

    public String createDeleteQuery(String field){
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ");
        sb.append(field+" = ?");
        return sb.toString();
    }

    /**
     *
     * @param id
     * @param entityId
     * delete() method gets a connection with the database and executes a deletion in the database.
     */
    public void delete(int id, String entityId){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = createDeleteQuery(entityId);
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, this.getType().getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(stmt);
            ConnectionFactory.close(connection);
        }

    }
}
