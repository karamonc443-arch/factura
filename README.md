# factura
Aplicación para gestionar facturas de compras



---
## DIAGRAMA UML UTILIZADO PARA ESTE PROYECTO
<img width="1755" height="856" alt="image" src="https://github.com/user-attachments/assets/f61e82b5-9ba5-4aac-990d-170a493e4ef1" />

---

## 🎨 Cómo personalizar los colores de los comentarios en IntelliJ IDEA

- **1.** Pulsa las teclas `Ctrl + Alt + S` para abrir la configuración de IntelliJ IDEA.

- **2.** Ve a `Editor → TODO` (si tienes el IDE en español, puede aparecer como **TODO por implementar**).

- **3.** Una vez allí, haz clic en **Patrones**. Pulsa el símbolo `+` para agregar un nuevo patrón o el símbolo `-` para eliminar uno que ya no quieras utilizar.

- **4.** Personaliza los patrones a tu gusto para sacarles el máximo provecho.

- **5.** Para crear un patrón personalizado, utiliza una expresión regular como la siguiente:

  ```regex
  \bIMPORTANTE\b.*

Sustituye `IMPORTANTE` por la palabra que quieras reconocer y asígnale el color que prefieras.

Por ejemplo, en mi caso he elegido el color rojo porque representa algo importante para mí. De esta manera, podré identificar rápidamente estos comentarios cuando revise mi código.

- 6. A continuación, os dejaré algunas capturas de pantalla con los pasos que debéis seguir y algunos ejemplos de los resultados obtenidos.
---
### 💡 Algunos ejemplos de patrones

| Etiqueta | Expresión regular | Color sugerido |
| --- | --- | --- |
| `PENDIENTE` | `\bPENDIENTE\b.*` | Amarillo |
| `IMPORTANTE` | `\bIMPORTANTE\b.*` | Rojo |
| `NOTA` | `\bNOTA\b.*` | Verde |
| `REVISAR` | `\bREVISAR\b.*` | Turquesa |

---

### ⚠️ Nota importante

La expresión regular `\bIMPORTANTE\b.*` reconoce la palabra `IMPORTANTE` y el texto que aparece después en la misma línea.

- `\b` indica un límite de palabra.
- `.*` permite reconocer el resto del texto de esa línea.

¡Personaliza tus comentarios y dale más color a tu código! 🚀
---
## EJEMPLOS
<img width="1233" height="873" alt="image" src="https://github.com/user-attachments/assets/c81b7f24-af89-4fd4-918f-93eace06ccfa" />
---
## RESULTADOS
<img width="1225" height="790" alt="image" src="https://github.com/user-attachments/assets/f4a231b3-6ec5-4f31-bb42-e425cdde9ee6" />
---
<img width="1175" height="779" alt="image" src="https://github.com/user-attachments/assets/2b33fe21-ac4f-4183-a465-78a141b70a38" />



