package arquitetura

import (
	"runtime"
	"testing"
)

func TestDependente(t *testing.T) {

	// executa o teste em paralelo
	t.Parallel()

	if runtime.GOARCH == "amd64" {

		t.Skip("Nao funciona em arquitetura amd64")
	}
	t.Fail()
}
