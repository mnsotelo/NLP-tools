# LOAD MODE 1: Fastest way to load the data (setting the limit). Needs .vec data
from gensim.models.keyedvectors import KeyedVectors
wordvectors_file_vec = 'data/YOUR_MODEL.vec'
amount_of_lines_to_load = 100000
wordvectors = KeyedVectors.load_word2vec_format(wordvectors_file_vec, limit=amount_of_lines_to_load)

# LOAD MODE 2: More expensive (computational resources and time) to load data but obviously more accurate. Needs .bin data
#from gensim.models.wrappers import FastText
#wordvectors_file = 'data/YOURMODEL'
#wordvectors = FastText.load_fasttext_format(wordvectors_file)

# NOTE: In the input parameters, it has some problems if there are words that contain accents letters or "ñ" symbol.

# Tool: Analogies. Output list of words. As input: positive and negative words.
analogies_words = wordvectors.most_similar_cosmul(positive=['rey','mujer'],negative=['hombre'])
print(analogies_words)

# Tool: Similarity (0 to 1) between two words. As input: two words to analyze similarity
similarity = wordvectors.similarity('coche', 'moto')
print(str(similarity))

# Tool: Find the word that doesn't belong to the group of words. As input: list of words. As output: a word.
word_doesnt_belong = wordvectors.doesnt_match(['blanco','azul','rojo','peru'])
print(word_doesnt_belong)

# More examples at: https://radimrehurek.com/gensim/models/keyedvectors.html