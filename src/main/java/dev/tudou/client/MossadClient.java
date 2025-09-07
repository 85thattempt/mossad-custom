package dev.tudou.client;

import net.fabricmc.api.ClientModInitializer;

public class MossadClient implements ClientModInitializer {

    public static final String MOD_ID = "mossad";
    public static final String MOD_NAME = "Mossad";
    public static final String VERSION = "1.0.0";
    public static final String MINECRAFT_VERSION = "1.21.5";
    public static final String ENVIRONMENT = "client";
    public static final String DEPENDENCIES = "required-after:fabric@[0.83.0,0.83.1]";
    public static final String GROUP = "dev.tudou";
    public static final String ARTIFACT = "mossad";
    public static final String REPOSITORY = "https://maven.tudou.dev/releases";


    @Override
    public void onInitializeClient() {
    }
}
