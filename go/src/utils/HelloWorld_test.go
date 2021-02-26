package utils

import (
	"testing"
)

func Test_apply(t *testing.T) {
	ans := apply("Geek")
	if ans != "Hello-World Geek!" {
		t.Errorf("apply(\"Geek\") = %s; want  \"Hello-World Geek!\"", ans)
	}
}
