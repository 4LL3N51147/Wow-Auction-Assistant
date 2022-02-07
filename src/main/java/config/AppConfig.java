package config;

import java.net.URL;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yilunyang
 * @date 2/7/2022
 */
@Configuration
@EnableConfigurationProperties
@Data
public class AppConfig {
  private URL tokenUrl;
  private String encoding;
  private URL baseUrl;
  private URL baseImageUrl;
  private Float compressionQuality;
}
