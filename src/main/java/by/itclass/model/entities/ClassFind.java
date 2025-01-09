package by.itclass.model.entities;

public class ClassFind {
    private String vendor;
    private String model;

    public ClassFind(String vendor, String model) {
        this.vendor = vendor;
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassFind{");
        sb.append("vendor='").append(vendor).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
