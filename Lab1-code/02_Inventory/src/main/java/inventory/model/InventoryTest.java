package inventory.model;

import inventory.repository.InventoryRepository;
import inventory.service.InventoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private static final List<Part> partList = new ArrayList<>();
    private static Inventory inv = new Inventory();

    @BeforeEach
    void setUp() {
        inv=new Inventory();
    }


    @Test
    void WBT_D1() throws Exception {
        String serchText = "abc";
        ArrayList result = inv.lookupPart(serchText);
        assert result.size() == 0;

    }

    @Test
    void WBT_D2() throws Exception {
        String serchText = "aaa";
        Part p1 = new InhousePart(1,"abc",2.0,7,1,9,12);
        inv.addPart(p1);
        ArrayList result = inv.lookupPart(serchText);
        assert result.size() == 0;

    }

    @Test
    void WBT_D3(){
        String serchText = "aaa";
        Part p1 = new InhousePart(1,"abc",2.0,7,1,9,12);
        Part p2 = new InhousePart(2,"abc",2.0,7,1,9,12);
        inv.addPart(p1);
        inv.addPart(p2);
        ArrayList result = inv.lookupPart(serchText);
        assert result.size() == 0;
    }

    @Test
    void WBT_D4(){
        String serchText = "aaa";
        Part p1 = new InhousePart(1,"aaaa",2.0,7,1,9,12);
        inv.addPart(p1);
        ArrayList result = inv.lookupPart(serchText);
        assert result.size() == 1;

    }

    @Test
    void WBT_D5(){
        String serchText = "aaa";
        Part p1 = new InhousePart(1,"aaaa",2.0,7,1,9,12);
        Part p2 = new InhousePart(2,"abc",2.0,7,1,9,12);
        inv.addPart(p1);
        inv.addPart(p2);

        ArrayList result = inv.lookupPart(serchText);
        assert result.size() == 1;

    }

    @Test
    void WBT_Invalid(){

    }

}