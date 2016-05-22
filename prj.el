(jde-project-file-version "1.0")
(jde-set-variables)

; Specifies the directory into which to place the compiled class. 
;(setq jde-compile-option-directory "/media/uraplutonium/Workstation/Workspace/Artificial\ Intelligence/bin")

; Specifies the classpath for compile command. If set, this variable overrides jde-global-classpath. 
(setq jde-compile-option-classpath (quote ("/media/uraplutonium/Workstation/Workspace/Artificial_Intelligence/src")))

; Startup directory for running or debugging Java applications.
;(setq jde-run-working-directory "/media/uraplutonium/Workstation/Workspace/Artificial\ Intelligence/bin")

; Specifies the classpath for  the Java interpreter. This option overrides the jde-global-classpath option. 
(setq jde-run-option-classpath (quote ("/media/uraplutonium/Workstation/Workspace/Artificial_Intelligence/bin")))

(jde-set-variables '(jde-enable-abbrev-mode t))
