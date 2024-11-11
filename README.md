For documentation in Portuguese, see the [README in Portuguese](docs/README.pt.md).

# Discord Webhook Java Library

[![](https://jitpack.io/v/eduardomcb/discord-webhook.svg)](https://jitpack.io/#eduardomcb/discord-webhook)
![GitHub](https://img.shields.io/github/license/eduardomcb/discord-webhook)

This is a Java library that simplifies the process of sending messages to Discord webhooks. It offers an easy way to integrate Discord channel messages into your Java projects.

## Table of Contents

- [Installation](#installation)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributions](#contributions)
- [License](#license)

## Installation

To install this library, follow these steps:

### Step 1: Add the JitPack repository to your `pom.xml` file:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### Step 2: Add the dependency:

```xml
<dependency>
    <groupId>com.github.eduardomcb</groupId>
    <artifactId>discord-webhook</artifactId>
    <version>1.0.0</version>
</dependency>
```

For Gradle, use the following configuration:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.eduardomcb:discord-webhook:1.0.0'
}
```

## Getting Started

To get started, create a Discord webhook URL that you can use to send messages. You can do this by following these steps:

1. Open Discord and go to the server or channel where you want to send messages.
2. Click on "Server Settings" or "Channel Settings."
3. In the left sidebar, click on "Integrations."
4. Click the "Create Webhook" button and follow the prompts to create your webhook URL.

## Usage

Here's a basic example of how to use this library to send a message to a Discord webhook:

```java
// Create a simple message
Message message = new Message()
        .setContent("Hello, world!");

// Create a WebhookManager object and configure it
WebhookManager webhookManager = new WebhookManager()
        .setChannelUrl("YOUR_WEBHOOK_URL_HERE")
        .setMessage(message);

// Send the message and handle the response
webhookManager.setListener(new WebhookClient.Callback() {
    @Override
    public void onSuccess(String response) {
        System.out.println("Message sent successfully");
    }

    @Override
    public void onFailure(int statusCode, String errorMessage) {
        System.out.println("Code: " + statusCode + " error: " + errorMessage);
    }
});

webhookManager.exec();
```

Replace `"YOUR_WEBHOOK_URL_HERE"` with the actual webhook URL you created.

## Contributions

If you'd like to contribute to the development of this library, feel free to open an [issue](https://github.com/eduardomcb/discord-webhook/issues) or submit a [pull request](https://github.com/eduardomcb/discord-webhook/pulls) on GitHub.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
