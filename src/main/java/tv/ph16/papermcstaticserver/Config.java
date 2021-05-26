package tv.ph16.papermcstaticserver;

import java.util.Optional;

import org.bukkit.configuration.Configuration;
import org.jetbrains.annotations.NotNull;

/**
 * Configuration information for the server.
 */
final class Config {
    private static final String RESOURCES_PATH_CONFIG = "resourcesPath";
    private static final String DIRECTORIES_LISTED_CONFIG = "directoriesListed";
    private static final String ACCEPT_RANGES_CONFIG = "acceptRanges";
    private static final String CONTEXT_PATH_CONFIG = "contextPath";

    /**
     * Plugin configuration.
     */
    private final Configuration config;

    /**
     * Creates a new instance of the {@see Config} class.
     * @param config the plugin configuration.
     */
    public Config(@NotNull Configuration config) {
        this.config = config;
    }

    /**
     * Gets the location of the static resources.
     * @return the location of the static resources.
     */
    @NotNull
    public Optional<String> getResourcesPath() {
        if (config.contains(RESOURCES_PATH_CONFIG)) {
            String staticPath = config.getString(RESOURCES_PATH_CONFIG);
            if (staticPath != null) {
                return Optional.of(staticPath);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets whether directory listings should be shown.
     * @return true if directory listings should be show; otherwise, false.
     */
    public boolean getDirectoriesListed() {
        return config.getBoolean(DIRECTORIES_LISTED_CONFIG, false);
    }

    /**
     * Gets whether range requests should be accepted.
     * @return true if range requests should be accepted; otherwise, false.
     */
    public boolean getAcceptRanges() {
        return config.getBoolean(ACCEPT_RANGES_CONFIG, false);
    }

    /**
     * Gets the path to respond to.
     * @return the path to respond to.
     */
    @NotNull
    public String getContextPath() {
        return config.getString(CONTEXT_PATH_CONFIG, "/");
    }
}
