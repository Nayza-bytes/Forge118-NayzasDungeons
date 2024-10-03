package net.nayza.nayzasdungeons.util.ModRessource;

import net.minecraft.ResourceLocationException;
import net.nayza.nayzasdungeons.NayzasDungeons;
import org.apache.commons.lang3.StringUtils;

public class ResourceLocation extends net.minecraft.resources.ResourceLocation{
    public static final char NAMESPACE_SEPARATOR = ':';
    public static final String DEFAULT_MOD_NAMESPACE = NayzasDungeons.MOD_ID;
    protected final String namespace;
    protected final String path;


    public ResourceLocation(String[] DecomposedLocation) {
        super(DecomposedLocation);
        this.namespace = StringUtils.isEmpty(DecomposedLocation[0]) ? "nayzasdungeons" : DecomposedLocation[0];
        this.path = DecomposedLocation[1];
        if(!isValidNamespace(this.namespace)) {
            throw new ResourceLocationException("Invalid Namespace Character at location: " + this.namespace + ":" + this.path);
        } else if(!isValidPath(this.path)) {
            throw new ResourceLocationException("Invalid Path Character at location: " + this.namespace + ":" + this.path);
        }
    }

    public ResourceLocation(String Location) {  this(decompose(Location, ':'));    }

    public ResourceLocation(String Namespace, String Path) { this(new String[]{Namespace, Path}); }

    protected static String[] decompose(String Location, char Separator) {
        String[] astring = new String[]{"nayzasdungeons", Location};
        int i = Location.indexOf(Separator);
        if(i >= 0) {
            astring[1] = Location.substring(i + 1, Location.length());
            if(i >= 1) {
                astring[0] = Location.substring(0, i);
            }
        }

        return astring;
    }

    public static boolean isValidResourceLocation(String pLocation) {
        String[] astring = decompose(pLocation, ':');
        return isValidNamespace(StringUtils.isEmpty(astring[0]) ? "minecraft" : astring[0]) && isValidPath(astring[1]);
    }

    private static boolean isValidNamespace(String Namespace) {
        for(int i = 0; i < Namespace.length(); i++) {
            if(!validNamespaceChar(Namespace.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidPath(String Path) {
        for(int i = 0; i < Path.length(); i++) {
            if(!validPathChar(Path.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean validNamespaceChar(char NamespaceChar) {
        return NamespaceChar == '_' || NamespaceChar == '-' || NamespaceChar >= 'a' && NamespaceChar <= 'z' || NamespaceChar >= '0' && NamespaceChar <= '9' || NamespaceChar == '.';
    }

    public static boolean validPathChar(char PathChar) {
        return PathChar == '_' || PathChar == '-' || PathChar >= 'a' && PathChar <= 'z' || PathChar >= '0' && PathChar <= '9' || PathChar == '/' || PathChar == '.';
    }
}
