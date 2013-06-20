secureApiSimpleClient
=====================

A Grails app that implements a simple client to facilitate the testing/implementation of the secureApi plugin.


# Introduction

This application provides a GUI for testing an app that implements [Secure API Grails Plugin](https://github.com/eduardm/secureApiGrailsPlugin).

It also contains 2 simple Java classes that are implementing the client authorization (signing requests) to access API secured with the Secure API plugin.

# Installation

Download, run server on port 8090. Browse http://localhost8080

Download [Secure Api Sample Implementation App](https://github.com/eduardm/secureApiSampleImplementationApp) and start it on port 80.

Do requests with valid pair of client key and client secret defined in config file.
