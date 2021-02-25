const apply = require('./test01.js');

	test('Hello-World Test', function () {
		var expected = "Hello-World Geek!";
		var result = apply("Geek");
		expect(result).toBe(expected);
	});
