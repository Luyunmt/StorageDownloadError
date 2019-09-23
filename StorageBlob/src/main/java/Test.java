import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.azure.core.credentials.TokenCredential;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.BlockBlobClient;
import com.azure.storage.blob.ContainerClient;
import com.azure.storage.common.credentials.SASTokenCredential;
import com.azure.storage.common.credentials.SharedKeyCredential;
import com.azure.identity.credential.ClientSecretCredential;
import com.azure.identity.credential.ClientSecretCredentialBuilder;
import com.azure.identity.credential.DefaultAzureCredential;
import com.azure.identity.credential.DefaultAzureCredentialBuilder;
public class Test {

    public static void main(String[] args) throws IOException {
        SASTokenCredential credential=SASTokenCredential.fromSASTokenString("{SasToken}");
        DefaultAzureCredential credential1=new DefaultAzureCredentialBuilder().build();;
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
        .endpoint("https://{Storageaccount}.blob.core.windows.net/")
        .credential("credential or credential1")
        .buildClient();
        blobServiceClient.createContainer("mycontainer");
        BlockBlobClient blockBlobClient = blobServiceClient.getContainerClient("mycontainer").getBlockBlobClient("myblob");
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            blockBlobClient.download(outputStream);
            System.out.println("Download completed.");
            File file=new File("Your File Path");
            FileOutputStream fos = new FileOutputStream(file);
            outputStream.writeTo(fos);
        }  
    }
}