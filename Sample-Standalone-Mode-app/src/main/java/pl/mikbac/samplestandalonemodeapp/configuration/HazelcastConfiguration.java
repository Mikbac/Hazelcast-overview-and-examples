package pl.mikbac.samplestandalonemodeapp.configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pl.mikbac.samplestandalonemodeapp.model.SampleModel;

/**
 * Created by MikBac on 05.11.2023
 */

@Configuration
public class HazelcastConfiguration {

    @Bean
    @Primary
    public HazelcastInstance instance(final ClientConfig clientConfig) {
        return HazelcastClient.newHazelcastClient(clientConfig);
    }

    @Bean
    public ClientConfig config() {
        var clientConfig = new ClientConfig();

        clientConfig.setClusterName("hello-world");

        clientConfig.getNetworkConfig()
                .setSmartRouting(true)
                .setConnectionTimeout(5000);

        return clientConfig;
    }

    @Bean
    public IMap<String, SampleModel> namesMap(HazelcastInstance instance) {
        return instance.getMap("namesMap");
    }

}
