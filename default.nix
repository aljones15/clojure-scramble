with import <nixpkgs> {}; {
  leinEnv = stdenv.mkDerivation {
    name = "leinClojure";
    JAVA_HOME ="${openjdk}";
    JAVA_PATH ="${openjdk}";
    buildInputs = [leiningen openjdk];
  };
}
