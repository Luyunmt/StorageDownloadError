import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.BlockBlobClient;
public class Test {

    public static void main(String[] args) throws IOException {
        String connectString="YOUR STORAGEACCOUNT CONNECTSTRING";
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
        .endpoint("https://{Storageaccount}.blob.core.windows.net/")
        .connectionString(connectString)
        .buildClient();
        blobServiceClient.createContainer("mycontainer");
        BlockBlobClient blockBlobClient = blobServiceClient.getContainerClient("mycontainer").getBlockBlobClient("myblob");
        String dataSample = "samples";
        try (ByteArrayInputStream dataStream = new ByteArrayInputStream(dataSample.getBytes())) {
            blockBlobClient.upload(dataStream, dataSample.length());
        }
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            blockBlobClient.download(outputStream);
            System.out.println("Download completed.");
            File file=new File("Your File Path");
            FileOutputStream fos = new FileOutputStream(file);
            outputStream.writeTo(fos);
        }  
    }
}