package pl.example.hazelcastoverviewandexamples.configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by MikBac on 07.10.2023
 */

@Configuration
public class HazelcastConfiguration {

    @Bean
    public Config config() {
        var config = new Config();

        // Ports range
        // (optional)
        config.setClusterName("Sample-cluster");
        config.getNetworkConfig()
                .getJoin()
                .getMulticastConfig()
                .setEnabled(true);

        // ------------------------------------------------------------------------------

        // Ports range
        // (optional)
//        config.getNetworkConfig()
//                .setPort(5900)
//                .setPortAutoIncrement(false);

        // ------------------------------------------------------------------------------

        // The join configuration element is used to discover Hazelcast members and enable them to form a cluster.
        // Hazelcast provides Auto Detection, Multicast, TCP/IP, AWS, Kubernetes, Azure, GCP, Eureka, and more.
        // (optional)
//        config.getNetworkConfig()
//                .getJoin()
//                .getTcpIpConfig()
//                        .addMember("192.168.1.104");

        // ------------------------------------------------------------------------------

        //
        // (optional)
//        config.setManagementCenterConfig(
//                new ManagementCenterConfig()
//                        .setConsoleEnabled(true)
//        );


        final MapConfig countriesCache = new MapConfig("countriesCache");
        countriesCache.setTimeToLiveSeconds(60);
        config.addMapConfig(countriesCache);

        return config;
    }

    @Bean
    public HazelcastInstance instance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public IMap<String, String> namesMap(HazelcastInstance instance) {
        return instance.getMap("namesMap");
    }

}
