# PaperMC Static Server

![Latest Release on GitHub](https://img.shields.io/github/v/release/ph16-productions/tv.ph16.papermcstaticserver?style=for-the-badge&label=Latest%20Release%20on%20GitHub)
![MIT License](https://img.shields.io/github/license/ph16-productions/tv.ph16.papermcstaticserver?style=for-the-badge)
![Minecraft API Version](https://img.shields.io/badge/dynamic/yaml?label=Minecraft%20API%20Version&query=%24%5B%27api-version%27%5D&url=https%3A%2F%2Fraw.githubusercontent.com%2FPH16-Productions%2Ftv.ph16.papermcstaticserver%2Fmain%2Fsrc%2Fmain%2Fresources%2Fplugin.yml&style=for-the-badge)
![Java Version](https://img.shields.io/badge/dynamic/xml?label=Java%20Version&query=%2F%2F%2A%5Blocal-name%28%29%20%3D%20%27java.version%27%5D&url=https%3A%2F%2Fraw.githubusercontent.com%2FPH16-Productions%2Ftv.ph16.papermcstaticserver%2Fmain%2Fpom.xml&style=for-the-badge)

Adds a static content server to PaperMC.

## Dependencies

[![org.jetbrains:annotations:20.1.0](https://img.shields.io/badge/JetBrains%20Java%20Annotations-v20.1.0-blue?style=for-the-badge)](https://search.maven.org/artifact/org.jetbrains/annotations/20.1.0/jar)
[![tv.ph16:papermchttpserver:2.2.11](https://img.shields.io/badge/PaperMC%20HTTP%20Server-v3.0.0-blue?style=for-the-badge)](https://github.com/PH16-Productions/tv.ph16.papermchttpserver/packages/788909?version=3.0.0)

## Configuration Options

- `resourcesPath`: the location of the static resources.
- `directoriesListed`: true if directory listings should be show; otherwise, false.
- `acceptRanges`: true if range requests should be accepted; otherwise, false.
- `contextPath`: the path to respond to.