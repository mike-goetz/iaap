package ch.mike.goetz.iaap.server;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application.masterdata")
public class MasterdataImportProperty {

  private final Map<String, Resource> images = new HashMap<>();

  private final Map<String, Resource> files = new HashMap<>();

  public Map<String, Resource> getImages() {
    return images;
  }

  public Map<String, Resource> getFiles() {
    return files;
  }

}
