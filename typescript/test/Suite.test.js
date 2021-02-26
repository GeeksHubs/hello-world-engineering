const { apply } = require("../src/HelloWorld")

describe('Testing', function () {

    test('Hello-World Geek!', function(){
        var exp = 'Hello-World Geek!'
        var res = apply('Geek')
        expect(res).toBe(exp)
    })
    
})