# Document Retrieval System with Inverted Index and Ternary Search Tree (TST)

Academic project developed for the **Design and Analysis of Algorithms II** (*Projeto e Análise de Algoritmos II*) course at **Mackenzie Presbyterian University (FCI)**.

The application provides an information retrieval engine designed to perform fast boolean-based searches across unstructured legal documents (such as court petitions, opinions, and briefs). The core data structure is an **Inverted Index** implemented with a custom **Ternary Search Tree (TST)**.

---

## 📌 Context & Motivation

Performing sequential full-text scans across large document collections incurs an impractical linear cost ($O(N \cdot M)$) per query.

To eliminate this bottleneck, the engine pre-indexes all terms into an **inverted index**. Rather than mapping `document → terms`, the inverted index maps each unique `term → list of associated documents`.

The index uses a **Ternary Search Tree (TST)**, combining the memory efficiency of a Binary Search Tree with the fast prefix-matching characteristics of a Trie.

---

## 🚀 Features

- **Batch Document Indexing:** Automatic discovery, parsing, and tokenization of multiple `.txt` files.
- **Custom Ternary Search Tree (TST):** Node-based implementation using `left`, `mid`, and `right` pointers, end-of-word markers, and posting lists.
- **Text Normalization:**
  - Case-insensitive token matching.
  - Punctuation stripping and symbol sanitization.
- **Boolean Query Engine:**
  - Single-term retrieval.
  - **`E` (AND)** operator via set intersection.
  - **`OU` (OR)** operator via set union.
  - **`NAO` (NOT)** operator via set difference.
  - Operator precedence: `NAO` > `E` > `OU`.
- **De-duplication:** Prevents duplicate document references within any single term's posting list.

---

## 🛠️ Architecture & Data Structures

### 1. Ternary Search Tree (TST) Node Layout
Each node stores a character `c` and three child pointers:
- `left`: Characters lexicographically smaller than `c`.
- `mid`: The subsequent character in the word sequence.
- `right`: Characters lexicographically greater than `c`.
- `fimDaPalavra` / `isEndOfWord`: Boolean flag indicating completion of a valid term.
- `arquivos` / `associatedFiles`: Posting list holding the filenames containing the term.

### 2. Set Operations for Boolean Retrieval
- $A \text{ AND } B \implies Docs(A) \cap Docs(B)$
- $A \text{ OR } B \implies Docs(A) \cup Docs(B)$
- $\text{NOT } C \implies U \setminus Docs(C)$ (where $U$ is the universal set of all indexed documents)

---

## ⚖️ Academic Guidelines & Constraints

This project adheres strictly to course specifications prohibiting high-level associative containers from the standard library (such as `HashMap`, `TreeMap`, `HashSet`, or `TreeSet`) for the primary index engine. The index is built from custom node references and dynamic pointer traversal.
