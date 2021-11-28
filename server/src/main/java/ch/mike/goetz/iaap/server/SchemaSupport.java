package ch.mike.goetz.iaap.server;

import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.ResourceUtils;

/**
 * Remove auto-generated schema files before JPA generates them. Otherwise new content will be appended to the files.
 */
@Configuration
public class SchemaSupport {

  @Bean
  public BeanFactoryPostProcessor schemaFilesCleanupPostProcessor(Environment env) {
    if (Arrays.stream(env.getActiveProfiles()).anyMatch(s -> StringUtils.equals(s, "test"))) {
      return bf -> {
        delete("src/test/resources/db/base/h2");
      };
    } else {
      return bf -> {
        delete("server/src/main/resources/db/base/mysql");
      };
    }
  }

  private void delete(String resourceLocation) {
    try {
      FileUtils.forceDelete(ResourceUtils.getFile(resourceLocation));
    } catch (IOException e) {
      //ignore
    }
  }
}
