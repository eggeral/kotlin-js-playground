import java.io.File
import javax.script.ScriptEngine
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

    evalFile(nashorn, "playground/build/classes/main/lib/kotlin.js")
    evalFile(nashorn, "playground/build/classes/main/playground_main.js")
}

fun evalFile(nashorn: ScriptEngine, fileName: String) {
    var file = File(fileName)
    if (!file.exists()) {
        file = File("../$fileName")
    }
    nashorn.eval("load('${file.canonicalPath}')")
}

