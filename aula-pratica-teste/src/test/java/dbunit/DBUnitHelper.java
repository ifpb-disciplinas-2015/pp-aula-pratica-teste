package dbunit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.operation.TransactionOperation;

public class DBUnitHelper {

    private final Connection connection = ConnectionHelper.getConnection();

    public void cleanInsert(String resourcePath) {
        execute(resourcePath, TransactionOperation.CLEAN_INSERT);
    }

    public void truncateAndInsert(String resourcePath) {
        execute(resourcePath, TransactionOperation.TRUNCATE_TABLE);
        execute(resourcePath, TransactionOperation.INSERT);
    }

    public void insert(String resourcePath) {
        execute(resourcePath, DatabaseOperation.INSERT);
    }

    public void delete(String resourcePath) {
        execute(resourcePath, DatabaseOperation.DELETE);
    }

    public void deleteAll(String resourcePath) {
        execute(resourcePath, DatabaseOperation.DELETE_ALL);
    }

    public void truncate(String resourcePath) {
        execute(resourcePath, DatabaseOperation.TRUNCATE_TABLE);
    }

    private void execute(String resourcePath, DatabaseOperation... operations) {
        try {
            InputStream resourceAsStream = edu.ifpb.pp.infraestrutura.db.DBUnitHelper.class.getResourceAsStream(resourcePath);

            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            builder.setCaseSensitiveTableNames(true);
            IDataSet dataSet = builder.build(resourceAsStream);

            ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);
            replacementDataSet.addReplacementObject("[null]", null);
            IDatabaseConnection iConnection = new DatabaseConnection(connection);

            for (DatabaseOperation operation : operations) {
                operation.execute(iConnection, replacementDataSet);
            }
            resourceAsStream.close();
        } catch (DatabaseUnitException e) {
            throw new edu.ifpb.pp.infraestrutura.db.InfrastructureException(e.getMessage(), e);
        } catch (SQLException e) {
            throw new edu.ifpb.pp.infraestrutura.db.InfrastructureException(e.getMessage(), e);
        } catch (IOException e) {
            throw new edu.ifpb.pp.infraestrutura.db.InfrastructureException(e.getMessage(), e);
        }
//        try {
//            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
//            builder.setCaseSensitiveTableNames(true);
//            IDatabaseConnection iConnection = new DatabaseConnection(connection);
//            InputStream is = getClass().getResourceAsStream(resourcePath);
//            IDataSet dataSetm = builder.build(is);
//            operation.execute(iConnection, dataSetm);
//        } catch (DatabaseUnitException e) {
//            throw new InfrastructureException(e.getMessage(), e);
//        } catch (SQLException e) {
//            throw new InfrastructureException(e.getMessage(), e);
//        }
    }

}
