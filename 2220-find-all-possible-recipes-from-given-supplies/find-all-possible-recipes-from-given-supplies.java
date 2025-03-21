class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availableIngredients = new HashSet<>(Arrays.asList(supplies));

        // Graph adjacency list and in-degree map
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        // Initialize in-degree for each recipe to 0
        for (String recipe : recipes) {
            inDegree.put(recipe, 0);
        }

        // Build the graph
        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                // If an ingredient is not initially available, treat it as a dependency
                if (!availableIngredients.contains(ingredient)) {
                    graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
                    inDegree.put(recipes[i], inDegree.getOrDefault(recipes[i], 0) + 1);
                }
            }
        }

        // Queue to process recipes with all ingredients available
        Queue<String> queue = new LinkedList<>();

        // Start with supplies that are already available
        for (int i = 0; i < recipes.length; i++) {
            if (inDegree.get(recipes[i]) == 0) {
                queue.offer(recipes[i]);
            }
        }

        // Result list for recipes that can be made
        List<String> result = new ArrayList<>();

        // Topological Sort (Kahn's Algorithm)
        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);

            // Treat the completed recipe as a new available ingredient
            availableIngredients.add(current);

            // Check all recipes dependent on the current recipe
            if (!graph.containsKey(current)) continue;

            for (String dependentRecipe : graph.get(current)) {
                inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);

                // If all dependencies are met, add to the queue
                if (inDegree.get(dependentRecipe) == 0) {
                    queue.offer(dependentRecipe);
                }
            }
        }

        return result;
    }
}