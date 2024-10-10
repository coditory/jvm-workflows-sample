# Contributing

## Pre commit hook (optional)

Installing pre-commit hook is optional but can save you some headache when pushing unformatted code.

Installing git pre-commit hook that formats code with [Ktlint](https://pinterest.github.io/ktlint):

```sh
cp scripts/git/pre-commit .git/hooks/pre-commit
```

## Commit messages

Before writing a commit message read [this article](https://chris.beams.io/posts/git-commit/).

## Build

Before pushing any changes make sure project builds without errors with:

```
./gradlew build
```

## Unit tests

This project uses [Kotest](https://kotest.io/) for testing.

- Make sure tests clearly document new features
- Any new feature must be unit tested

## Validate changes locally

Before submitting a pull request, test your changes locally on a sample project.
There are few ways for local testing:

- simply use one of the [sample subprojects](/samples)
- or publish library to maven local repository with `./gradlew publishToMavenLocal` and use it in any project via [`mavenLocal()`](https://docs.gradle.org/current/userguide/declaring_repositories.html#sub:maven_local) repository

## Validating with snapshot release

Snapshot release is triggered automatically after merge to the main branch.
To use a released snapshot version make sure to register Sonatype snapshot repository in gradle with:

```
// build.gradle.kts
repositories {
    mavenCentral()
    maven {
        url = URI("https://oss.sonatype.org/content/repositories/snapshots")
    }
}
```

The snapshot version can be found in GitHub Action build log.

## Documentation

If change adds new feature or modifies an existing one update [README](/README.md) and [documentation](/docs).

To locally preview documentation changes follow instructions in [docs/README.md](/docs)