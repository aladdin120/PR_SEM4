package LAB7.Proxy;

public class ProxyDocumentRequest implements Document {
    private String name;

    public ProxyDocumentRequest(String name) {
        this.name = name;
    }


    @Override
    public void request() {
        System.out.println("Your document with new functional:" + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
