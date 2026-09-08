# Document Retrieval System with Inverted Index and Ternary Search Tree (TST)

Academic project developed for the **Design and Analysis of Algorithms II** (*Projeto e Análise de Algoritmos II*) course at **Mackenzie Presbyterian University (FCI)**[cite: 1].

The application provides an information retrieval engine designed to perform fast boolean-based searches across unstructured legal documents (such as court petitions, opinions, and briefs)[cite: 1]. The core data structure is an **Inverted Index** implemented with a custom **Ternary Search Tree (TST)**[cite: 1].

---

## 📌 Context & Motivation

Performing sequential full-text scans across large document collections incurs an impractical linear cost ($O(N \cdot M)$) per query[cite: 1].

To eliminate this bottleneck, the engine pre-indexes all terms into an **inverted index**[cite: 1]. Rather than mapping `document → terms`, the inverted index maps each unique `term → list of associated documents`[cite: 1].

The index uses a **Ternary Search Tree (TST)**, combining the memory efficiency of a Binary Search Tree with the fast prefix-matching characteristics of a Trie[cite: 1].

---

## 🚀 Features

- **Batch Document Indexing:** Automatic discovery, parsing, and tokenization of multiple `.txt` files[cite: 1].
- **Custom Ternary Search Tree (TST):** Node-based implementation using `left`, `mid`, and `right` pointers, end-of-word markers, and posting lists[cite: 1].
- **Text Normalization:**
  - Case-insensitive token matching[cite: 1].
  - Punctuation stripping and symbol sanitization[cite: 1].
- **Boolean Query Engine:**
  - Single-term retrieval[cite: 1].
  - **`E` (AND)** operator via set intersection[cite: 1].
  - **`OU` (OR)** operator via set union[cite: 1].
  - **`NAO` (NOT)** operator via set difference[cite: 1].
  - Operator precedence: `NAO` > `E` > `OU`[cite: 1].
- **De-duplication:** Prevents duplicate document references within any single term's posting list[cite: 1].

---

## 🛠️ Architecture & Data Structures

### 1. Ternary Search Tree (TST) Node Layout
Each node stores a character `c` and three child pointers[cite: 1]:
- `left`: Characters lexicographically smaller than `c`[cite: 1].
- `mid`: The subsequent character in the word sequence[cite: 1].
- `right`: Characters lexicographically greater than `c`[cite: 1].
- `fimDaPalavra` / `isEndOfWord`: Boolean flag indicating completion of a valid term[cite: 1].
- `arquivos` / `associatedFiles`: Posting list holding the filenames containing the term[cite: 1].

### 2. Set Operations for Boolean Retrieval
- $A \text{ AND } B \implies Docs(A) \cap Docs(B)$
- $A \text{ OR } B \implies Docs(A) \cup Docs(B)$
- $\text{NOT } C \implies U \setminus Docs(C)$ (where $U$ is the universal set of all indexed documents)

---

## ⚖️ Academic Guidelines & Constraints

This project adheres strictly to course specifications prohibiting high-level associative containers from the standard library (such as `HashMap`, `TreeMap`, `HashSet`, or `TreeSet`) for the primary index engine[cite: 1]. The index is built from custom node references and dynamic pointer traversal[cite: 1].
