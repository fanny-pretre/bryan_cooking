import { Box, Typography } from "@mui/material";

import MealCardSummary from "./MealCardSummary";

const MealCardSummaryList = () => {
  const meals = [1, 2];

  return (
    <Box
      sx={{
        width: "100%",
      }}
    >
      <Typography
        variant="h5"
        sx={{
          fontWeight: 600,
          mb: 3,
        }}
      >
        A venir
      </Typography>

      <Box
        sx={{
          display: "flex",
          flexDirection: {
            xs: "column",
            sm: "row",
          },
          flexWrap: "wrap",
          justifyContent: "center",
          gap: 3,
        }}
      >
        {meals.map((meal) => (
          <MealCardSummary key={meal} />
        ))}
      </Box>
    </Box>
  );
};

export default MealCardSummaryList;
