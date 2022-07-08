package strings

import "testing"

const msgIndex = "%s (parte: %s) - indices: esperado (%d) <> encotrado (%d)."

func TestIndex(t *testing.T) {

	testes := []struct {
		texto    string
		parte    string
		esperado int
	}{
		{"Cod3r é show", "Cod3r", 0},
		{"", "", 0},
		{"OPa", "Opa", -1},
		{"leonardo", "o", 2},
	}

	for _, teste := range testes {
		t.Logf("Massa: %v", teste)
		atual := strings.Index(teste.texto, teste.parte)

		if atual != teste.esperado {
			t.Errorf(msgIndex, teste.texto, teste.parte, teste.esperado, atual)
		}
	}
}
