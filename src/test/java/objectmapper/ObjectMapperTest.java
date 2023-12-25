//package objectmapper;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//import java.net.URL;
//import java.util.Random;
//
//public class ObjectMapperTest {
//
//    @Test
//    void sampleCodeTest() throws JsonProcessingException {
//        String postJSON = """
//                {
//                    "userId": 1,
//                    "id": 1,
//                    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//                    "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
//                  }""";
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Post post = objectMapper.readValue(postJSON, Post.class);
//        System.out.println(post);
//
//        System.out.println("****************************************");
//
//        String valueAsString = objectMapper.writeValueAsString(post);
//        System.out.println(valueAsString);
//    }
//
//
//    @Test
//    void objectFromStringReader() throws IOException {
//        String postJSON = """
//                {
//                    "userId": 1,
//                    "id": 1,
//                    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//                    "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
//                  }""";
//
//        StringReader stringReader = new StringReader(postJSON);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Post post = objectMapper.readValue(stringReader, Post.class);
//
//        System.out.println(post.getTitle());
//    }
//
//
//    @Test
//    void objectFromFile() throws IOException {
//        File file = new File("data/file.txt");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Post post = objectMapper.readValue(file, Post.class);
//
//        System.out.println(post.getTitle());
//    }
//
//
//    @Test
//    void objectFromFileUrl() throws Exception {
//        int postId = new Random().nextInt(1, 100);
//        URL url = new URL("https://jsonplaceholder.typicode.com/posts/" + postId);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Post post = objectMapper.readValue(url, Post.class);
//
//        System.out.println(post);
//    }
//
//
//    @Test
//    void objectFromInputStream() throws IOException {
//        InputStream is = new FileInputStream("data/file.txt");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Post post = objectMapper.readValue(is, Post.class);
//
//        System.out.println(post.getTitle());
//    }
//
//
//    @Test
//    void jsonFromObject() throws IOException {
//        Post post = new Post(2, 5, "qui est esse", "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        OutputStream os = new FileOutputStream("data/serialize.json");
//        objectMapper.writeValue(os, post);
//
//        String postJson = objectMapper.writeValueAsString(post);
//
//        System.out.println(postJson);
//    }
//
//
//    @Test
//    void yamlFromObject() throws IOException {
//        YAMLFactory yamlFactory = new YAMLFactory();
//        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
//
//        Post post = new Post(2, 5, "qui est esse", "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla");
//
//        String postJson = objectMapper.writeValueAsString(post);
//        System.out.println(postJson);
//    }
//}
