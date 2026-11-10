# kotlin-test-project (limited)

Deliberately vulnerable Kotlin fixture for Mend SAST gen2 (Kotlin) automation tests.
Do **not** deploy — every file plants a known finding on purpose.

Each file is a **self-contained flow**: the taint source (servlet request parameter) and
the dangerous sink live in the same file, with no cross-file call graph, so a taint-based
engine can trace every planted finding.

| File | CWE | Expected severity |
|------|-----|-------------------|
| `Sqli.kt` | CWE-89 SQL Injection | High |
| `Xss.kt` | CWE-79 Cross-Site Scripting | High |
| `CommandInjection.kt` | CWE-78 OS Command Injection | High |
| `WeakCrypto.kt` | CWE-327 / CWE-328 Weak crypto & hash | Medium / Low |
| `HardcodedCredentials.kt` | CWE-798 Hard-Coded Credentials | Medium |
