package BinarySearchTree;

public class Organism implements Comparable<Organism>{
    private String code;
    private String type;
    private String description;
    private double genomeSize;

    public Organism(String code, String type, String description, double genomeSize) {
        super();
        this.code = code;
        this.type = type;
        this.description = description;
        this.genomeSize = genomeSize;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getGenomeSize() {
        return genomeSize;
    }

    public void setGenomeSize(int genomeSize) {
        this.genomeSize = genomeSize;
    }

    @Override
    public int compareTo(Organism o) {
        return this.code.compareTo(o.code);
    }
}
