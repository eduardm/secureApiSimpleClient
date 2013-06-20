package apisigner

class MainController {
    def apiSignerService

    def index() {
        if (request.post) {
            def key = params.key,
                secret = params.secret,
                url = params.url,
                method = params.method,
                result = apiSignerService.makeRequest(key, secret, url, method)
            return [result: result]
        }
    }

    def cucu() {
        if (request.post) {
            def result = apiSignerService.calculateRFC2104HMAC(params.data, params.secret)
            return [result:result]
        }
    }
}
