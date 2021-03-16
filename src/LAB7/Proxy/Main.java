package LAB7.Proxy;

public class Main {
    public static void main(String[] args) {
        Document document = new DocumentRequest("Diary");
        document.request();
        document = new ProxyDocumentRequest(document.getName());
        document.request();
    }
}
