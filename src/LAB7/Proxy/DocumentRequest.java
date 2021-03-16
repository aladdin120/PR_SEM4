package LAB7.Proxy;

public class DocumentRequest implements Document {
    private String name;

    public DocumentRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void request() {
        System.out.println("Your document: " + name);
    }
}
