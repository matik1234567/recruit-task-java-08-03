// implements Block, for WallTest class purpose
public class StaticBlock implements Block{

    private String color;
    private String material;
    public StaticBlock(String color, String meterial){
        this.color = color;
        this.material = meterial;
    }
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
