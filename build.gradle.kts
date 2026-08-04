//        kill Gobakubousi plugin
//        Copyright (C) 2026  yukkurihimatubus
//
//        This program is free software: you can redistribute it and/or modify
//        it under the terms of the GNU General Public License as published by
//        the Free Software Foundation, either version 3 of the License, or
//        (at your option) any later version.
//
//        This program is distributed in the hope that it will be useful,
//        but WITHOUT ANY WARRANTY; without even the implied warranty of
//        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//        GNU General Public License for more details.
//
//        You should have received a copy of the GNU General Public License
//        along with this program.  If not, see https://www.gnu.org/licenses/.

//ビルドに使用するプラグインを指定
plugins {
    java
}
//グループID
group = "com.yukkurihimatubus"
//version
version = "1.1"

//使用するリポジトリを指定
repositories {
    mavenCentral()
    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    // 26.2などの最新バージョンに対応した指定方法
    compileOnly("io.papermc.paper:paper-api:26.2.build.+")
}

//Javaのversionを指定
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

//paper-plugin.ymlで、version: "${version}"が自動的にversion: "1.0"みたいに置き換えられるやつを追加
tasks.withType<ProcessResources> {
    val props = mapOf("version" to project.version)
    inputs.properties(props)

    filteringCharset = "UTF-8"
    filesMatching("**/paper-plugin.yml") {
        expand(props)
    }
    filesMatching("**/plugin.yml") {
        expand(props)
    }
}