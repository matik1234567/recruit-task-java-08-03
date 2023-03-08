import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block>blocks){
        this.blocks = blocks;
    }

    public Wall(){
        blocks = new ArrayList<>();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream().flatMap(block -> {
                    if (block instanceof CompositeBlock) {
                        return ((CompositeBlock) block).getBlocks().stream();
                    } else {
                        return Stream.of(block);
                    }
                })
                .filter(block -> color.equals(block.getColor())).findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().flatMap(block -> {
            if (block instanceof CompositeBlock) {
                return ((CompositeBlock) block).getBlocks().stream();
            } else {
                return Stream.of(block);
            }
        }).filter(block -> material.equals(block.getMaterial())).collect(Collectors.toList());
    }

    @Override
    public int count() {
        //return blocks.size();
        return (int) blocks.stream().flatMap(block -> {
            if (block instanceof CompositeBlock) {
                return ((CompositeBlock) block).getBlocks().stream();
            } else {
                return Stream.of(block);
            }
        }).count();
    }
}
