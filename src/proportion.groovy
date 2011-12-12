#!/usr/bin/env groovy
// Assign each url in a list an equal amount of clicks, based on clicks

def assignUrls(urls, clicks) {
    def i = 0
    def stack = []
    clicks.downto(1) {
        if (stack.size() == 0) {
            stack = urls.clone()
        }
        def url = stack.remove(0)
        url.clicks++
    }
}

def resetUrls(num) {

    def urls = []
    0.upto(num - 1) {
        urls.add([ url:"foo${it}", clicks:0])
    
    }
    return urls
}


def urls = resetUrls(5)
assignUrls(urls, 5)

// all urls should have 1 click
assert urls[0].clicks == 1
assert urls[0].url == "foo0"

assert urls[1].clicks == 1
assert urls[1].url == "foo1"

assert urls[-1].url == "foo4"
assert urls[-1].clicks == 1


def urls7 = resetUrls(7)
assignUrls(urls7, 1)

assert urls7[0].url == "foo0"
assert urls7[0].clicks == 1

assert urls7[1].url == "foo1"
assert urls7[1].clicks == 0

assert urls7[2].url == "foo2"
assert urls7[2].clicks == 0

assert urls7[6].url == "foo6"
assert urls7[6].clicks == 0

// each url will get at least 11
// 8 clicks will be left over, so the first 8 will get 12
def urls16 = resetUrls(16)
assignUrls(urls16, 184)

0.upto(7) {
    assert urls16[it].url == "foo${it}"
    assert urls16[it].clicks == 12
}
8.upto(urls16.size() - 1) {
    assert urls16[it].url == "foo${it}"
    assert urls16[it].clicks == 11
}
