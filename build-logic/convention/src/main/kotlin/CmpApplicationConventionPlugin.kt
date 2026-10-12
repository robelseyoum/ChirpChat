import com.roba.chirp.convention.configureAndroidTarget
import com.roba.chirp.convention.configureIosTargets
import com.roba.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CmpApplicationConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.kotlin.multiplatform.library")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            configureAndroidTarget()
            configureIosTargets()

            dependencies.add(
                "androidRuntimeClasspath",
                libs.findLibrary("compose-uiTooling").get()
            )
        }
    }
}
