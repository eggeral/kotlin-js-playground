import java.io.File
import javax.script.ScriptEngineManager

fun main(args: Array<String>) {
    val nashorn = ScriptEngineManager().getEngineByName("nashorn")
    nashorn.eval(
            """
            var console = {
                log : function(msg) {
                    print(msg);
                }
            };
            """
    )
    nashorn.eval("load('${File("lost-type-info-in-inheritance-hierarchy/build/classes/main/lib/kotlin.js").canonicalPath}')")
    nashorn.eval("load('${File("lost-type-info-in-inheritance-hierarchy/build/classes/main/lost-type-info-in-inheritance-hierarchy_main.js").canonicalPath}')")

}

