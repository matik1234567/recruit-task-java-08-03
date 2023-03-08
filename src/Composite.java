import java.util.List;

// implements CompositeBlock, for WallTest class purpose
public class Composite implements CompositeBlock{

    private List<Block> blocks;

    public Composite(List<Block>blocks){
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
