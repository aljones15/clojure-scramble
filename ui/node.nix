with import <nixpkgs> { }; 
{ 
    nodeEnv = stdenv.mkDerivation rec  {
     name = "nodejs";
     buildInputs = ["/home/liminal18/.node_modules" 
                    nodejs-9_x sass watchman yarn];
     NPM_CONFIG_PREFIX="/home/liminal18/.node_modules";
};
} 
