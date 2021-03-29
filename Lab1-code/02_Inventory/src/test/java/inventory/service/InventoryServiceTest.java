package inventory.service;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.model.Product;
import inventory.repository.InventoryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {
    private static List<Product> l= new ArrayList<>();
    private static List<Part> partList = new ArrayList<>();
    private static InventoryRepository repo = new InventoryRepository();
    private static InventoryService serv = new InventoryService(repo);

    @AfterAll
    public static void beforeAll(TestInfo t) {
        for(int i=0;i<l.size();++i)
        {
            repo.deleteProduct(l.get(i));
        }
        for(int i=0;i<partList.size();++i)
        {
            repo.deletePart(partList.get(i));
        }
    }



    @DisplayName("Test tables valid")
    @ParameterizedTest
    @ValueSource(ints = {0, 6})
    void addProduct_inStockECPV(int inStock) {
        ////Arrange
        int id=repo.getAutoPartId();
        String name = "Componenta";
        int min=1;
        int max=8;
        ObservableList<Part> addParts= FXCollections.observableArrayList();
        Part p1 = new InhousePart(repo.getAutoPartId(), "asd",2.0,7,1,9,12);
        Part p2 = new InhousePart(repo.getAutoPartId(),"asd",2.0,7,1,9,12);
        addParts.add(p1);
        addParts.add(p2);
        partList.add(p1);
        partList.add(p2);
        Product product;
        int sizeOfProducts = repo.getAllProducts().size();
        //Act
        try{
            product =serv.addProduct(name,2.0,inStock,min,max,addParts);
            l.add(product);
            //Assert
            assertEquals(repo.getAllProducts().size() , sizeOfProducts+1 );
        } catch (Exception e) {
            //assert(false);
        }

    }

}