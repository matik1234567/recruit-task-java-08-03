import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


class WallTest {
    Wall wall;
    @BeforeEach
    void setUp(){
        List<Block>blocks = new ArrayList<>();
        blocks.add(new StaticBlock("red", "metallic"));
        blocks.add(new StaticBlock("blue", "metallic"));
        blocks.add(new StaticBlock("green", "plastic"));
        blocks.add(new StaticBlock("green", "metallic"));

        StaticBlock brick2 = new StaticBlock("orange", "metallic");
        StaticBlock brick3 = new StaticBlock("green", "wooden");
        ArrayList<Block> composite = new ArrayList<>();
        composite.add(brick2);
        composite.add(brick3);

        Composite compBrick = new Composite(composite);

        blocks.add(compBrick);
        wall = new Wall(blocks);
    }
    @Test
    void findBlockByColor() {
        Optional<Block> block = wall.findBlockByColor("green");
        assertEquals("green",  block.orElseThrow().getColor());
        block = wall.findBlockByColor("yellow");
        assertFalse(block.isPresent());
    }
    @Test
    void findBlocksByMaterial() {
        // fetch metallic blocks
        ArrayList<Block>blocksMetallic = (ArrayList<Block>) wall.findBlocksByMaterial("metallic");
        // try to get plastic from metallic
        Block plasticBlock =  blocksMetallic.stream().filter(block -> "plastic".equals(block.getMaterial())).findAny().orElse(null);
        assertNull(plasticBlock);
        Block woodenBlock =  blocksMetallic.stream().filter(block -> "wooden".equals(block.getMaterial())).findAny().orElse(null);
        assertNull(woodenBlock);
        assertEquals(4, blocksMetallic.size());
    }
    @Test
    void count() {
        assertEquals(6, wall.count());
    }
}