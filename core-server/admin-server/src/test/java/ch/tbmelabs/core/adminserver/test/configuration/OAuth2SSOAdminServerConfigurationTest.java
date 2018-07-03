package ch.tbmelabs.core.adminserver.test.configuration;

import static org.assertj.core.api.Assertions.assertThat;

import ch.tbmelabs.tv.core.adminserver.configuration.OAuth2SSOAdminServerConfiguration;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;

public class OAuth2SSOAdminServerConfigurationTest {

  @Test
  public void eurekaConfigurationShouldBeAnnotated() {
    assertThat(OAuth2SSOAdminServerConfiguration.class).hasAnnotation(Configuration.class)
        .hasAnnotation(EnableOAuth2Sso.class).hasAnnotation(EnableAdminServer.class);
  }

  @Test
  public void oAuth2AdminServerShouldHavePublicConstructor() {
    assertThat(new OAuth2SSOAdminServerConfiguration()).isNotNull();
  }
}
