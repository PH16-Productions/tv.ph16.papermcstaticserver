package tv.ph16.papermcstaticserver;

import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

/**
 * Static content server for PaperMC.
 */
public final class Plugin extends JavaPlugin {
    private final Config config;
    private tv.ph16.papermchttpserver.Plugin httpPlugin;
    private ResourceHandler handler;
    private ContextHandler contextHandler;

    /**
     * Creates a new instance of the {@see Plugin} class.
     */
    public Plugin() {
        config = new Config(getConfig());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onLoad() {
        try {
            httpPlugin = getPlugin(tv.ph16.papermchttpserver.Plugin.class);
        } catch (IllegalStateException e) {
            httpPlugin = null;
            getLogger().log(Level.SEVERE, "Missing required plugin.", e);
        }
        if (httpPlugin != null) {
            config.getResourcesPath().ifPresent(resourcesPath -> {
                try {
                    handler = new ResourceHandler();
                    handler.setBaseResource(Resource.newResource(resourcesPath));
                    handler.setDirectoriesListed(config.getDirectoriesListed());
                    handler.setWelcomeFiles(new String[]{"index.html","index.htm","index.xhtml"});
                    handler.setAcceptRanges(config.getAcceptRanges());
                    handler.setDirAllowed(config.getDirectoriesListed());
                } catch (IOException e) {
                    handler = null;
                    getLogger().log(Level.SEVERE, "Error creatintg static server", e);
                }
            });
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onEnable() {
        contextHandler = httpPlugin.addHandler(config.getContextPath(), handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDisable() {
        if (contextHandler != null) {
            httpPlugin.removeHandler(contextHandler.getContextPath());
        }
    }
}
