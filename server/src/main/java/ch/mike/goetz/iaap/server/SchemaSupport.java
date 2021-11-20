package ch.mike.goetz.iaap.server;

import java.io.IOException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

/**
 * Remove auto-generated schema files before JPA generates them. Otherwise new content will be appended to the files.
 */
@Configuration
public class SchemaSupport {

  @Bean
  public BeanFactoryPostProcessor schemaFilesCleanupPostProcessor() {
    return bf -> {
      delete("server/src/main/resources/db/schema_create.sql");
      delete("server/src/main/resources/db/schema_drop.sql");
      delete("src/main/resources/db/h2_schema_create.sql");
      delete("src/main/resources/db/h2_schema_drop.sql");
    };
  }

  private void delete(String resourceLocation) {
    try {
      FileUtils.forceDelete(ResourceUtils.getFile(resourceLocation));
    } catch (IOException e) {
      //ignore
    }
  }
}
