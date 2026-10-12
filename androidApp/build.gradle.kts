plugins {
    alias(libs.plugins.convention.android.application.compose)
    alias(libs.plugins.compose.hot.reload)
}
dependencies {
    implementation(project(":shared"))

    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.designsystem)
    implementation(projects.core.presentation)


    implementation(projects.feature.auth.domain)
    implementation(projects.feature.auth.presentation)

    implementation(projects.feature.chat.data)
    implementation(projects.feature.chat.database)
    implementation(projects.feature.chat.domain)
    implementation(projects.feature.chat.persentaion)

    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
